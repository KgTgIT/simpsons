$(document).ready(function () {

    $("#operation-form").submit(function (event) {
        // stop submit the form, we will post it manually.
        event.preventDefault();
        createPhrase();
    });

    handleRowSelection('#charactersTable', '#phrasesButton', '#characterId');
    handleRowSelection('#phrasesTable', '#deleteButton', '#phraseId');
});

/**
 * Handles selection in table.
 * @param tableSelector the selector providing table which selected row will be enriched with active class
 * @param buttonSelector the selector to button which which is enabled based on active selection
 * @param fieldSelector the selector to field holding row id
 */
function handleRowSelection(tableSelector, buttonSelector, fieldSelector) {
    $(tableSelector).on('click', '.clickable-row', function () {
        if ($(this).hasClass('active')) {
            $(this).removeClass('active');
            $(fieldSelector).val('');
            $(buttonSelector).addClass('disabled');
        } else {
            const value = $(this).children('td').html();
            $(fieldSelector).val(value);
            $(buttonSelector).removeClass('disabled');
            $(this).addClass('active').siblings().removeClass('active');
        }
    });
}

function openPhrases() {
    const characterId = getSelectorValue('#characterId');
    // Changing somehow thymeleaf motel attribute would be better
    window.location = "/phrases?characterId=" + characterId;
}

function createPhrase() {
    disableSelector('#button-accept', true);
    removeClassAndClearBody('#feedback', "alert alert-danger alert-info");

    const characterId = getSelectorValue('#characterId');

    const requestBody = {
        "characterId": characterId,
        "phrase": getSelectorValue('#phrase')
    };

    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: `simpsons/v1/characters/${characterId}/phrases`,
        data: JSON.stringify(requestBody),
        dataType: 'json',
        cache: false,
        timeout: 600000,
        success: function (data, status, xhr) {
            const locationHeader = xhr.getResponseHeader('Location');
            const newPhrase = data.phrase;
            const msg = createdPhraseMessage(newPhrase, locationHeader);
            addClassWithHtml('#feedback', "alert alert-info", msg);
            disableSelector("#button-accept", false);
            $("#phrase").val("");
            const newRow = createNewPhraseRow(data.id, newPhrase);
            $('#phrasesTable tr:last').after(newRow);
            removeClassAndClearBody('#phaseDetails', "alert alert-danger alert-info");
        },
        error: function (e) {
            console.log("ERROR : ", e);
            const errorMsg = getErrorMessage(e);
            addClassWithHtml('#feedback', "alert alert-danger", errorMsg);
            disableSelector("#button-accept", false);
        }
    });
}

function createdPhraseMessage(phrase, locationHeader) {
    return `
	Operation ended successfully, new phrase: ${phrase}</br>
	To see phrase details click: <a href='javascript:getPhraseDetails(${JSON.stringify(locationHeader)});'>here</a>
	`;
}

function createNewPhraseRow(id, text) {
    return `
	<tr class="clickable-row info">
		<td id="phraseIdColumn" hidden>
			${id}
		</td>
		<td>
			${text}
		</td>
	</tr>
	`;
}

/**
 * Disables specified selector
 * @param selector the selector
 * @param disabled whether selected item should be disabled
 */
function disableSelector(selector, disabled) {
    $(selector).prop("disabled", disabled);
}

function getPhraseDetails(createdPhraseUrl) {
    removeClassAndClearBody('#phaseDetails', "alert alert-danger alert-info");

    $.ajax({
        type: "GET",
        contentType: "application/json",
        url: createdPhraseUrl,
        dataType: 'json',
        cache: false,
        timeout: 600000,
        success: function (data) {
            const message = `ID: ${data.id}, character ID: ${data.characterId}, phrase:</br>${data.phrase}`;
            addClassWithHtml('#phaseDetails', "alert alert-info", message);
        },
        error: function (e) {
            console.log("ERROR : ", e);
            const errorMsg = getErrorMessage(e);
            addClassWithHtml('#phaseDetails', "alert alert-danger", errorMsg);
        }
    });
}

/**
 * Enriches element by applying specified className and htmlString.
 * @param selector The selector
 * @param className One or more space-separated classes to be added to the class attribute of each matched element.
 * @param htmlString A string of HTML to set as the content of each matched element.
 */
function addClassWithHtml(selector, className, htmlString) {
    $(selector).addClass(className)
        .html(htmlString);
}

/**
 * Clears element matching specified selector from className and content.
 * @param selector The selector
 * @param className One or more space-separated classes to be removed from the class attribute of each matched element.
 */
function removeClassAndClearBody(selector, className) {
    $(selector).removeClass(className)
        .html('');
}

function getErrorMessage(e) {
    const responseJson = e.responseJSON;
    let errorMsg;

    if (responseJson === undefined) {
        errorMsg = `Error ${e.status}: ${e.responseText}`;
    } else {
        errorMsg = `Error ${responseJson.status}: ${responseJson.message} at: ${responseJson.path}`;
    }

    return errorMsg;
}

function getSelectorValue(selector) {
    return $(selector).val();
}

function deletePhrase() {
    const phraseId = getSelectorValue('#phraseId');
    const characterId = getSelectorValue('#characterId');

    $.ajax({
        type: "DELETE",
        contentType: "application/json",
        url: `simpsons/v1/characters/${characterId}/phrases/${phraseId}`,
        cache: false,
        timeout: 600000,
        success: function () {
            addClassWithHtml('#phaseDetails', "alert alert-info", "Successfully removed phrase");
            $('#phrasesTable tr.active').remove();
            removeClassAndClearBody('#feedback', "alert alert-danger alert-info");
        },
        error: function (e) {
            console.log("ERROR : ", e);
            const errorMsg = getErrorMessage(e);
            addClassWithHtml('#phaseDetails', "alert alert-danger", errorMsg);
        }
    });
}
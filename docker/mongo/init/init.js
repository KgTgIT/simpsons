const COLLECTION_NAME_CHARACTERS = "characters";
const COLLECTION_NAME_PHRASES = "phrases";

const characters = [
    {
        "_id": "59edee68706374dfa957842f",
        "firstName": "Homer",
        "lastName": "Simpson",
        "picture": "http://www.trbimg.com/img-573a089a/turbine/ct-homer-simpson-live-pizza-debate-met-0517-20160516",
        "age": 43
    },
    {
        "_id": "59edee689509e51682ff8e02",
        "firstName": "Marge",
        "lastName": "Simpson",
        "picture": "https://vignette.wikia.nocookie.net/simpsons/images/8/87/Marge_Simpson_2.png/revision/latest?cb=20150131104556",
        "age": 40
    },
    {
        "_id": "59edee68eff3f80413c136f8",
        "firstName": "Lisa",
        "lastName": "Simpson",
        "picture": "https://vignette.wikia.nocookie.net/simpsons/images/1/12/Lisa_Simpson-0.png/revision/latest?cb=20161027220133",
        "age": 10
    },
    {
        "_id": "59edee683406c7834ee7cdd8",
        "firstName": "Bart",
        "lastName": "Simpson",
        "picture": "https://vignette.wikia.nocookie.net/simpsons/images/a/ab/BartSimpson.jpg/revision/latest?cb=20141101133153",
        "age": 12
    },
    {
        "_id": "59edee68b4b101bef064bf11",
        "firstName": "Hugo",
        "lastName": "Simpson",
        "picture": "https://static.simpsonswiki.com/images/thumb/1/1a/Hugo_Simpson.png/200px-Hugo_Simpson.png",
        "age": 12
    },
    {
        "_id": "59edee68874eb2fa23678344",
        "firstName": "Ned",
        "lastName": "Flanders",
        "picture": "https://vignette.wikia.nocookie.net/simpsons/images/8/84/Ned_Flanders.png/revision/latest?cb=20100513160156",
        "age": 50
    },
    {
        "_id": "59edee68efd448eefb265420",
        "firstName": "Rod",
        "lastName": "Flanders",
        "picture": "https://vignette.wikia.nocookie.net/simpsons/images/e/e6/Rod_Flanders2.png/revision/latest?cb=20140817110904",
        "age": 13
    },
    {
        "_id": "59edee68ea392a3947485d41",
        "firstName": "Todd",
        "lastName": "Flanders",
        "picture": "https://vignette.wikia.nocookie.net/simpsons/images/1/18/Todd_Flanders.png/revision/latest?cb=20131223200228",
        "age": 12
    },
    {
        "_id": "59edee682c7acf7bfac7e66b",
        "firstName": "Maude",
        "lastName": "Flanders",
        "picture": "https://vignette.wikia.nocookie.net/simpsons/images/9/95/Maude_Flanders.png/revision/latest/scale-to-width-down/286?cb=20170923223722",
        "age": 49
    }
];

const phrases = [
    {
        "_id": "59edff64d9be8f7aa11e0c44",
        "character": "59edee68706374dfa957842f",
        "phrase": "Wait a minute. Bart’s teacher is named ‘Krabappel’? Oh, I’ve been calling her ‘Crandall.’ Why didn’t anyone tell me? Ohhh, I’ve been making an idiot out of myself!"
    },
    {
        "_id": "59edff6492d619b4a933a56b",
        "character": "59edee68706374dfa957842f",
        "phrase": "Now we play the waiting game…Ahh, the waiting game sucks. Let’s play Hungry Hungry Hippos!"
    },
    {
        "_id": "59edff6477ac8539e526682b",
        "character": "59edee689509e51682ff8e02",
        "phrase": "Go out on a Tuesday? Who am I, Charlie Sheen?"
    },
    {
        "_id": "59edff647cf388e225bc5f4e",
        "character": "59edee689509e51682ff8e02",
        "phrase": "I brought you a tuna sandwich. They say it's brain food. I guess because there's so much dolphin in it, and you know how smart they are."
    },
    {
        "_id": "59edff64ac4dccc4b0e35784",
        "character": "59edee68eff3f80413c136f8",
        "phrase": "I’d be mortified if someone ever made a lousy product with the Simpson name on it."
    },
    {
        "_id": "59edff6419f9d6df24d593fe",
        "character": "59edee68eff3f80413c136f8",
        "phrase": "You monster! You monster!"
    },
    {
        "_id": "59edff6403042a54f6038044",
        "character": "59edee683406c7834ee7cdd8",
        "phrase": "There’s only one thing to do at a moment like this: strut!"
    },
    {
        "_id": "59edff643d4737e47c71835c",
        "character": "59edee683406c7834ee7cdd8",
        "phrase": "Aren’t we forgetting the true meaning of Christmas: the birth of Santa."
    },
    {
        "_id": "59edff641b4c1f62aebe1e4d",
        "character": "59edee68b4b101bef064bf11",
        "phrase": "I made a Pigeon-rat."
    },
    {
        "_id": "59edff643fbeca90867aa34d",
        "character": "59edee68b4b101bef064bf11",
        "phrase": "Am I? Well, perhaps we're all a little crazy. I know I am. I went mad after they tore us apart, but I'll be sane… once I sew us back together."
    },
    {
        "_id": "59edff6494f9aef192ef4813",
        "character": "59edee68874eb2fa23678344",
        "phrase": "Diddly"
    },
    {
        "_id": "59edff64e6597a07e8e5dd33",
        "character": "59edee68874eb2fa23678344",
        "phrase": "I give you the jury of the damned. Benedict Arnold, Lizzie Borden, Richard Nixon..."
    },
    {
        "_id": "59edff6458b6a68631660120",
        "character": "59edee68efd448eefb265420",
        "phrase": "We just move one space at a time. It's less fun that way."
    },
    {
        "_id": "59edff646c740f1218a30a06",
        "character": "59edee68efd448eefb265420",
        "phrase": "Thank you, door! "
    },
    {
        "_id": "59edff644abadfc108cac2a6",
        "character": "59edee68ea392a3947485d41",
        "phrase": "Daddy says dice are wicked."
    },
    {
        "_id": "59edff64b5988eeae9953b59",
        "character": "59edee68ea392a3947485d41",
        "phrase": "Thank you, door! "
    },
    {
        "_id": "59edff64fd7790417d74b3a1",
        "character": "59edee682c7acf7bfac7e66b",
        "phrase": "Oh, I don't care for the speed, but I can't get enough of that safety gear - helmets, roll bars, caution flags..."
    }
];

runScript();

function runScript() {
    db.createUser({
        user: "simpsons",
        pwd: "simpsons",
        roles: [
            {role: "dbOwner", db: "simpsons"}
        ]
    });

    print(`Importing characters started`);
    db[COLLECTION_NAME_CHARACTERS].insertMany(characters, {ordered: false});
    print(`Importing characters finished`);

    print(`Importing phrases started`);
    db[COLLECTION_NAME_PHRASES].insertMany(phrases, {ordered: false});
    print(`Importing phrases finished`);
}

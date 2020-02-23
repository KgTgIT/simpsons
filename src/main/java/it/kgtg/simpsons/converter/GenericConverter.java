package it.kgtg.simpsons.converter;

import it.kgtg.simpsons.dto.BaseDTO;
import it.kgtg.simpsons.model.BaseEntity;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Represents converter between DTO and Entity.
 */
public interface GenericConverter<E extends BaseEntity, D extends BaseDTO> {

	/**
	 * Creates entity from given DTO.
	 * 
	 * @param dto
	 *            the DTO to use
	 * @return entity
	 */
	E createFrom(D dto);

	/**
	 * Creates DTO from given entity.
	 * 
	 * @param entity
	 *            the entity to use
	 * @return DTO
	 */
	D createFrom(E entity);

	/**
	 * Updates entity based on specified DTO.
	 * 
	 * @param entity
	 *            the entity to update
	 * @param dto
	 *            the DTO to use
	 * @return updated entity
	 */
	E updateEntity(E entity, D dto);

	/**
	 * Constructs a list of DTOs from specified collection of entities.
	 * 
	 * @param entities
	 *            the collection of entities to transform
	 * @return list of DTOs
	 */
	default List<D> createFromEntities(final Collection<E> entities) {
		return entities.stream()
					   .map(this::createFrom)
					   .collect(Collectors.toList());
	}

	/**
	 * Constructs a list of entities from specified collection of DTOs.
	 * 
	 * @param dtos
	 *            the collection of DTOs to transform
	 * @return list of entities
	 */
	default List<E> createFromDtos(final Collection<D> dtos) {
		return dtos.stream()
				   .map(this::createFrom)
				   .collect(Collectors.toList());
	}

}
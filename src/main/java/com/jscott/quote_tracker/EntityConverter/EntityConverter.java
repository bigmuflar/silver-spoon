package com.jscott.quote_tracker.EntityConverter;

public interface EntityConverter<ENTITY, DTO> {

    public DTO convertToDTO(ENTITY entity);
    public ENTITY convertToEntity (DTO dto);
}

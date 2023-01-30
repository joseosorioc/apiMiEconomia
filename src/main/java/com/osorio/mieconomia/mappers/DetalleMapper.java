package com.osorio.mieconomia.mappers;

import com.osorio.developer.commons.models.Detalle;
import com.osorio.mieconomia.request.DetalleRequest;
import com.osorio.mieconomia.response.DetalleResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Mappings;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING )
public interface DetalleMapper {


    @Mappings({
            @Mapping(target = "elemento", source = "comentario"),
            @Mapping(target = "fechaCreacion", source = "fechaGeneracion")
    })
     DetalleResponse detalleToDetalleResponse(Detalle detalle);

     Detalle detalleRequestToDetalle(DetalleRequest detalleRequest);

}

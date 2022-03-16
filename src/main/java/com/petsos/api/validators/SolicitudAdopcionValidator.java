package com.petsos.api.validators;

import com.petsos.api.exception.IncorrectResourceRequestException;
import com.petsos.api.model.SolicitudAdopcion;

public class SolicitudAdopcionValidator {

    public static void validate(SolicitudAdopcion solicitudAdopcion) {

       if(solicitudAdopcion.getNombre() == null || solicitudAdopcion.getNombre().trim().isEmpty()) {
            throw new IncorrectResourceRequestException("El nombre es requerido");

        }

       if(solicitudAdopcion.getNombre().length() < 3) {
            throw new IncorrectResourceRequestException("El nombre debe ser mayor a 3 caracteres");

        }


        if(solicitudAdopcion.getApellido() == null || solicitudAdopcion.getApellido().trim().isEmpty()) {
            throw new IncorrectResourceRequestException("El apellido es requerido");

        }

        if(solicitudAdopcion.getApellido().length() < 10) {
            throw new IncorrectResourceRequestException("El apellido debe ser mayor a 10 caracteres");

        }

        if(solicitudAdopcion.getDni() == null) {
            throw new IncorrectResourceRequestException("El dni es requerido");
        }

        if(solicitudAdopcion.getDni().length() <8 || solicitudAdopcion.getDni().length() >8) {
            throw new IncorrectResourceRequestException("El dni debe tener 8 caracteres");
        }

        /*if(solicitudAdopcion.getMascota() == null || solicitudAdopcion.getMascota().getNombre().trim().isEmpty() ) {
            throw new IncorrectResourceRequestException("La mascota es requerida");

        }*/

        if(solicitudAdopcion.getDetalleSolicitud() == null || solicitudAdopcion.getDetalleSolicitud().trim().isEmpty()) {
            throw new IncorrectResourceRequestException("El detalle solicitud es requerido");

        }
      /*  if(solicitudAdopcion.getEstadoSolicitud() == null || solicitudAdopcion.getEstadoSolicitud().trim().isEmpty()) {
            throw new IncorrectResourceRequestException("El nombre es requerido");

        }*/

    }
}

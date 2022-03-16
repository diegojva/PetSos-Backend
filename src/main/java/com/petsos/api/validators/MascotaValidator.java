package com.petsos.api.validators;
import com.petsos.api.exception.IncorrectResourceRequestException;
import com.petsos.api.model.Mascota;

public class MascotaValidator {

    public static void validate(Mascota mascota){

        if(mascota.getTipo() == null || mascota.getTipo().trim().isEmpty()) {
            throw new IncorrectResourceRequestException("El tipo es requerido");

        }

        if(mascota.getTipo().length() < 3) {
            throw new IncorrectResourceRequestException("La tipo debe ser mayor a 3 caracteres");

        }

        if(mascota.getNombre() == null || mascota.getNombre().trim().isEmpty()) {
            throw new IncorrectResourceRequestException("El nombre es requerido");

        }

        if(mascota.getNombre().length() < 3) {
            throw new IncorrectResourceRequestException("El nombre debe ser mayor a 3 caracteres");

        }

        if(mascota.getEdad() == null) {
            throw new IncorrectResourceRequestException("La edad es requerida");
        }

        if(mascota.getEdad() <= 0) {
            throw new IncorrectResourceRequestException("La edad es incorrecta");
        }

        if(mascota.getTamano() == null || mascota.getTamano().trim().isEmpty()) {
            throw new IncorrectResourceRequestException("El tamaño es requerido");

        }

        if(mascota.getTamano().length() < 3) {
            throw new IncorrectResourceRequestException("La tamaño debe ser mayor a 3 caracteres");

        }

        if(mascota.getSexo() == null || mascota.getSexo().trim().isEmpty()) {
            throw new IncorrectResourceRequestException("La sexo es requerido");

        }

        if(mascota.getSexo().length() < 3) {
            throw new IncorrectResourceRequestException("El sexo debe ser mayor a 3 caracteres");

        }

        if(mascota.getNivel() == null || mascota.getNivel().trim().isEmpty()) {
            throw new IncorrectResourceRequestException("El nivel es requerido");

        }

        if(mascota.getNivel().length() < 3) {
            throw new IncorrectResourceRequestException("El nivel debe ser mayor a 3 caracteres");

        }

        if(mascota.getDescripcion() == null || mascota.getDescripcion().trim().isEmpty()) {
            throw new IncorrectResourceRequestException("La descripción es requerida");
        }

        if(mascota.getDescripcion().length() < 3) {
            throw new IncorrectResourceRequestException("La descripción debe ser mayor a 3 caracteres");
        }

        if(mascota.getFoto() == null || mascota.getFoto().trim().isEmpty()) {
            throw new IncorrectResourceRequestException("La foto es requerida");
        }

        if(mascota.getFoto().length() < 3) {
            throw new IncorrectResourceRequestException("La foto debe ser mayor a 3 caracteres");
        }

        if(mascota.getEstado() == null || mascota.getEstado().trim().isEmpty()) {
            throw new IncorrectResourceRequestException("El estado es requerido");
        }

        if(mascota.getEstado().length() != 1) {
            throw new IncorrectResourceRequestException("El estado debe tener sólo 1 caracter");
        }

    }

}

package pablo.tzeliks.application.dto;

public record CustomerRequestDTO(
        String name,
        String documentNumber,
        String streetAddress,
        String streetNumber,
        String neighborhood,
        String zipCode,
        String addressComplement,
        Long cityId
) {}

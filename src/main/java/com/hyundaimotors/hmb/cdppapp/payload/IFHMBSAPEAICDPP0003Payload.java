package com.hyundaimotors.hmb.cdppapp.payload;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

public class IFHMBSAPEAICDPP0003Payload {
    
    @Schema(name = "IFHMBSAPEAICDPP0003Payload.Request")
    @Getter
    @Setter
    public static class Request{
        @Schema(description = "FSC OCN unique code. This is the key field for integration.", example = "1-RGHT2")
        @NotNull @NotBlank @NotEmpty
        @JsonProperty("Name")
        private String name;
        @Schema(description = "Name of external system.", example = "")
        @NotNull @NotBlank @NotEmpty
        @JsonProperty("Source")
        private String source;
        @Schema(description = "Connex product type. It must be a literal value for the purpose of this project: Vehicle.", example = "Vehicle")
        @NotNull @NotBlank @NotEmpty
        @JsonProperty("Type")
        private String type;
        @Schema(description = "Vehicle description: E.g.:", example = "HB20 1.6L COMFORT PLUS MT")
        @JsonProperty("Part")
        private String part;
        @Schema(description = "Vehicle advanced description. E.g.:", example = "Ar-condicionado")
        private String advdesc; 
        @Schema(description = "Vehicle model year.", example = "2010")
        @JsonProperty("ModelYear")
        private int modelYear;
        @Schema(description = "Vehicle chassi model.", example = "Hatchback")
        private String chassiModel; 
        @Schema(description = "Vehicle body style.", example = " 998cc")
        @JsonProperty("BodyStyle")
        private String bodyStyle;
        @Schema(description = "Vehicle engine capacity description.", example = " DOHC")
        @JsonProperty("HMBCylindercapacity")
        private String hmbCylindercapacity;
        @Schema(description = "Vehicle engine type description. ", example = "MPI")
        @JsonProperty("Engine")
        private String engine;
        @Schema(description = "Vehicle engine friendly description.", example = "1.0 Turbo")
        private String engineDesc;
        @Schema(description = "Vehicle version friendly description. ", example = "Comfort Plus")
        private String versionDesc; 
        @Schema(description = "Vehicle transmission friendly description. ", example = "Manual 6 marchas")
        private String transmissionDesc;
        @Schema(description = "Vehicle transmission. ", example = "A.M")
        @JsonProperty("Transmission")
        private String transmission;
        @Schema(description = "Vehicle fuel type description.", example = "Flex")
        @JsonProperty("Fuel")
        private String fuel;
        @Schema(description = "Vehicle door amount. ", example = "5")
        private int doorsAmnt;
        @Schema(description = "Vehicle suggested price", example = "50000")
        private float suggestedPrice;
        @Schema(description = "Description", example = "Rede de porta-malas")
        @JsonProperty("Description")
        private String description;
        @Schema(description = "ProductTypeCode", example = "Product")
        @JsonProperty("ProductTypeCode")
        private String productTypeCode;
    }    

    @Schema(name = "IFHMBSAPEAICDPP0003Payload.Response")
    @Getter
    @Setter
    public static class Response{
        @Schema(description = "Connex error code. Code 200 means success.", example = "200")
        @JsonProperty("Error_spcCode")
        private String errorSpcCode;
        @Schema(description = "Connex error message.", example = "success")
        @JsonProperty("Error_spcMessage")
        private String errorSpcMessage;
    }
}

package ru.bellintegrator.practice.view;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.*;

@ApiModel(description = "Организация")
public class OrganizationView {

    @NotEmpty
    @ApiModelProperty(value = "Уникальный идентификатор", hidden = true, example = "1")
    public String id;


    @NotEmpty(message = "name cannot be null")
    @ApiModelProperty(value = "Имя", example = "Иван")
    public String name;

    @NotNull(message = "age cannot be null")
    @Min(18)
    @Max(200)
    @ApiModelProperty(value = "Возраст", example = "27")
    public Integer age;

    @Override
    public String toString() {
        return "{id:" + id + ";name:" + name + ";age:" + age + "}";
    }
}

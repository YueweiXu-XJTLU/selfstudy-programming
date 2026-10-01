package P196_Annotation;

public @interface MyAnnotation2_SpecialAttribute {
    String value(); //special attribute
    //if an annotation contain only an attribute (besides attributes with default values) "value", we can omit "value = "
}

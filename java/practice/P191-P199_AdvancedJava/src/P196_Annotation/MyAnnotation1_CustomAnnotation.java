package P196_Annotation;

//Custom Annotation 自定义注解
public @interface MyAnnotation1_CustomAnnotation {
  //public attributeType attributeName() default defaultValue;
    public String aString();
    boolean aBoolean() default true; //public can be omitted, it will be added automatically
    int[] anIntArray();
}

package P196_Annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//meta-annotation 元注解：annotation for annotation

//1.@Target(ElementType.???)
//state which position can this annotation be used
//TYPE(used for class, interface, ...); FIELD; METHOD; PARAMETER; CONSTRUCTOR; LOCAL_VARIABLE
@Target({ElementType.TYPE, ElementType.METHOD})

//2.@Retention()
//state the retention period of the annotation
//SOURCE(the annotation exist before compiled to .class); CLASS(default)(the annotation exist before run); RUNTIME(the always annotation exist)
@Retention(RetentionPolicy.CLASS)
public @interface MyAnnotation3_MetaAnnotation {
}

package P113_S3_EnumForSingleInstance;

public enum SingleInstance {
    X;
}

//This is an excellent (eager) single instance:
//1. contain only 1 object: X
//2. private constructor: default
//3. have the return method: SingleInstance sg = SingleInstance.X;

Reflection :collision:

Create an application to analyze and test java classes.
The application will receive as input java classes and it will display their prototypes and perform the tests specified by the @Test annotation.

The homework specifications of the application are:

    1. The input may be a folder (containing .class files) or a .jar. You must explore it recursively.
    
    2. Create the complete prototype, in the same manner as javap tool.
    
    3. Identify all public classes annotated with @Test and invoke the methods annotated with @Test, whether static or not.
    
    4. If a method requires primitive (at least int) or String arguments, generate mock values for them.
       Print a statistics regarding the tests.


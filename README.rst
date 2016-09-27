Kryo tree serialization stack overflow error sample project
===========================================================

try::

    mvn test

the test should fail with something like this::

    T E S T S
    -------------------------------------------------------
    Running com.gnandoo.AppTest
    Tests run: 1, Failures: 0, Errors: 1, Skipped: 0, Time elapsed: 0.125 sec <<< FAILURE! - in com.gnandoo.AppTest
    testApp(com.gnandoo.AppTest)  Time elapsed: 0.123 sec  <<< ERROR!
    com.esotericsoftware.kryo.KryoException: java.lang.IllegalArgumentException: Unable to create serializer "com.esotericsoftware.kryo.serializers.FieldSerializer" for class: com.gnandoo.Leaf
    Serialization trace:
    childs (com.gnandoo.Node)
    childs (com.gnandoo.Node)
        at com.esotericsoftware.kryo.serializers.ObjectField.write(ObjectField.java:82)
        at com.esotericsoftware.kryo.serializers.FieldSerializer.write(FieldSerializer.java:495)
        at com.esotericsoftware.kryo.Kryo.writeClassAndObject(Kryo.java:599)
        at com.esotericsoftware.kryo.serializers.MapSerializer.write(MapSerializer.java:95)
        at com.esotericsoftware.kryo.serializers.MapSerializer.write(MapSerializer.java:21)
        at com.esotericsoftware.kryo.Kryo.writeObject(Kryo.java:523)
        at com.esotericsoftware.kryo.serializers.ObjectField.write(ObjectField.java:61)
        at com.esotericsoftware.kryo.serializers.FieldSerializer.write(FieldSerializer.java:495)
        at com.esotericsoftware.kryo.Kryo.writeObject(Kryo.java:505)
        at com.gnandoo.AppTest.testApp(AppTest.java:47)
    Caused by: java.lang.IllegalArgumentException: Unable to create serializer "com.esotericsoftware.kryo.serializers.FieldSerializer" for class: com.gnandoo.Leaf
        at com.esotericsoftware.kryo.factories.ReflectionSerializerFactory.makeSerializer(ReflectionSerializerFactory.java:48)
        at com.esotericsoftware.kryo.factories.ReflectionSerializerFactory.makeSerializer(ReflectionSerializerFactory.java:26)
        at com.esotericsoftware.kryo.Kryo.newDefaultSerializer(Kryo.java:351)
        at com.esotericsoftware.kryo.Kryo.getDefaultSerializer(Kryo.java:344)
        at com.esotericsoftware.kryo.util.DefaultClassResolver.registerImplicit(DefaultClassResolver.java:56)
        at com.esotericsoftware.kryo.Kryo.getRegistration(Kryo.java:461)
        at com.esotericsoftware.kryo.util.DefaultClassResolver.writeClass(DefaultClassResolver.java:79)
        at com.esotericsoftware.kryo.Kryo.writeClass(Kryo.java:488)
        at com.esotericsoftware.kryo.Kryo.writeClassAndObject(Kryo.java:593)
        at com.esotericsoftware.kryo.serializers.MapSerializer.write(MapSerializer.java:95)
        at com.esotericsoftware.kryo.serializers.MapSerializer.write(MapSerializer.java:21)
        at com.esotericsoftware.kryo.Kryo.writeObject(Kryo.java:523)
        at com.esotericsoftware.kryo.serializers.ObjectField.write(ObjectField.java:61)
        ... 31 more
    Caused by: java.lang.reflect.InvocationTargetException
        at sun.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)
        at sun.reflect.NativeConstructorAccessorImpl.newInstance(NativeConstructorAccessorImpl.java:62)
        at sun.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45)
        at java.lang.reflect.Constructor.newInstance(Constructor.java:423)
        at com.esotericsoftware.kryo.factories.ReflectionSerializerFactory.makeSerializer(ReflectionSerializerFactory.java:35)
        ... 43 more
    Caused by: java.lang.StackOverflowError
        at java.util.HashMap.hash(HashMap.java:338)
        at java.util.HashMap.get(HashMap.java:556)
        at com.esotericsoftware.kryo.Generics.getConcreteClass(Generics.java:43)
        <last line repeated 100s of times>

License
-------

MIT

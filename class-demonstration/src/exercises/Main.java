package exercises;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws  ClassNotFoundException {
        Class<String> stringClass = String.class;
        Map<String,Integer> mapObject = new HashMap<>();

        Class<?> hashMapClass = mapObject.getClass();
        Class<?> squareClass = Class.forName("exercises.Main$Square");

        var circleObject = new Drawable(){
            @Override
            public int getNumberOfCorners() {
                return 0;
            }
        };


//        printClassInfo(stringClass,hashMapClass,squareClass);
        printClassInfo(Collection.class,boolean.class,int [][].class,Color.class,
                circleObject.getClass());


    }
    private static void printClassInfo(Class<?> ... classes){
        for(Class<?> clazz : classes){
            System.out.println(String.format("class name : %s,class package name : %s",
                    clazz.getSimpleName(),
                    clazz.getPackageName()));

            Class<?> [] implementedInterfaces = clazz.getInterfaces();
            if(implementedInterfaces.length > 0){
                System.out.println("Implemented interfaces : ");
                for(Class<?> implementedInterface : implementedInterfaces){
                    System.out.println(implementedInterface.getSimpleName());
                }
            }

            System.out.println("Is array : " + clazz.isArray());
            System.out.println("Is primitive : " + clazz.isPrimitive());
            System.out.println("Is enum : " + clazz.isEnum());
            System.out.println("Is interface : " + clazz.isInterface());
            System.out.println("Is annotation : " + clazz.isAnnotation());
            System.out.println("Is anonymous class : " + clazz.isAnonymousClass());


            System.out.println("\n");

        }
    }
    private static class Square implements  Drawable {
        @Override
        public int getNumberOfCorners() {
            return 4;
        }
    }
    private static interface  Drawable {
        int getNumberOfCorners();
    }
    private  enum Color {
        RED, GREEN, BLUE
    }
}

// why use static inner class?
// 1. if you want to use the inner class without instantiating the outer class  (e.g. Square class)
// 2. if you want to use the inner class outside the outer class (e.g. Drawable interface)
// 3. if you want to group classes that belong together (e.g. Color enum)

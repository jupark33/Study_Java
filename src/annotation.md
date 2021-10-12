Annotation

JDK5부터 추가된 기능. 자바 소스 코드에 추가적인 정보를 제공하는 메타데이터이다.
클래스, 메서드, 변수, 인자에 추가할 수 있다. 메타데이터이기 때문에 비즈니스 로직에 
직접적인 영향을 주지 않지만, 이 메타데이터 정보에 따라서 실행 흐름을 변경할 수 있는 
코딩이 가능하여 단지 어노테이션 추가만으로 더 깔끔한 코딩이 가능해진다.

어노테이션은 특별한 종류의 인터페이스를 의미한다.

어노테이션 종류
1 마커 어노테이션 @NewAnnotation
2 싱글 값 어노테이션 @NewAnnotation(id=10)
3 멀티 값 어노데이션 @NewAnnotation(id=10, name="hello")

마커 어노테이션 선언
public @interface MarkerAnnotation {
  public String name();
}

마커 어노테이션 사용
@MarkerAnnotation
public class UsingMarkerAnnotation {
  
}

위에서 선언한 MarkerAnnotation을 역컴파일 하면 다음과 같다.
public interface MarkerAnnotation extends java.lang.annotation.Annotation {
  public abstract java.lang.String value();
}

@interface는 자동으로 Annotation 클래스를 상속(확장)하며, 내부의 메소드들은 abstract
키워드가 자동으로 붙게 된다. 따라서 어노테이션 인터페이스는 extends 절을 가질 수 없으며,
추가적으로 다음과 같은 제약이 존재한다.
. 어노테이션 타입 선언은 제네릭일 수 없다.
. 메소드는 매개변수를 가질 수 없다.
. 메소드는 타입 매개변수를 가질 수 없다.
. 메소드 선언은 throws 절을 가질 수 없다.

어노테이션 자체로는 아무것도 해 주는 일이 없다. 메타데이터이므로 정보를 가짐으로서
역할을 다한다. 메타데이터를 사용하는 측에서는 리플렉션을 이용해야 한다.

package hello.springmvc.basic.domain.team;

public interface DomainEvent<T> {
    T getDomainId(); // 해당제네릭타입을쓰면 컴파일단계에서 에러로 걸러줌
}
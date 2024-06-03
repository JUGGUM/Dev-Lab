package hello.springmvc.basic.config.team;

public interface DomainEvent<T> {
    T getDomainId();
}
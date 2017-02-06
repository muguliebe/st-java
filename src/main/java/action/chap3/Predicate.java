package action.chap3;

@FunctionalInterface
public interface Predicate<C> {
	boolean test(C t);
}

package uk.ac.aston.oop.rdd.sim;

public interface CountAwareActor extends Actor {
	void setActorCount(Class<?> actorClass, int count);
}

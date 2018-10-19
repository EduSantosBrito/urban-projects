package com.sejaurban.projects.state;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.sejaurban.projects.exception.UnauthorizedChangeStateException;

@Entity
@DiscriminatorValue("Paused")
public class PausedState extends StatusState {

	public PausedState() {
	}

	@Override
	public StatusState negotiate() {
		throw new UnauthorizedChangeStateException();
	}

	@Override
	public StatusState develop() {
		return new DevelopmentState();
	}

	@Override
	public StatusState cancel() {
		return new CanceledState();
	}

	@Override
	public StatusState complete() {
		return new CompletedState();
	}

	@Override
	public StatusState pause() {
		throw new UnauthorizedChangeStateException();
	}

}

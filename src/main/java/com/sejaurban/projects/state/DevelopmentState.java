package com.sejaurban.projects.state;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.sejaurban.projects.exception.UnauthorizedChangeStateException;

@Entity
@DiscriminatorValue("Development")
public class DevelopmentState extends StatusState {

	public DevelopmentState() {
	}
	
	@Override
	public StatusState negotiate() {
		throw new UnauthorizedChangeStateException();
	}

	@Override
	public StatusState develop() {
		throw new UnauthorizedChangeStateException();
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
		return new PausedState();
	}

}

package com.sejaurban.projects.state;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.sejaurban.projects.exception.UnauthorizedChangeStateException;

@Entity
@DiscriminatorValue("Canceled")
public class CanceledState extends StatusState {

	public CanceledState() {
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
		throw new UnauthorizedChangeStateException();
	}

	@Override
	public StatusState complete() {
		throw new UnauthorizedChangeStateException();
	}

	@Override
	public StatusState pause() {
		throw new UnauthorizedChangeStateException();
	}

}

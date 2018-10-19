package com.sejaurban.projects.state;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.sejaurban.projects.exception.UnauthorizedChangeStateException;

@Entity
@DiscriminatorValue("Negotiation")
public class NegotiationState extends StatusState {

	public NegotiationState() {
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
		return new DevelopmentState();
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

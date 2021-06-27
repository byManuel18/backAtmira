package com.example.backend.models;

public class CloseApproach {

    private String close_approach_date;

	private String close_approach_date_full;

    private long epoch_date_close_approach;

    private RelativeVelocity relative_velocity;

    private MissDistance miss_distance;

    private String orbiting_body;
	
    public String getClose_approach_date() {
		return close_approach_date;
	}
	public String getClose_approach_date_full() {
		return close_approach_date_full;
	}
	public long getEpoch_date_close_approach() {
		return epoch_date_close_approach;
	}
	public RelativeVelocity getRelative_velocity() {
		return relative_velocity;
	}
	public MissDistance getMiss_distance() {
		return miss_distance;
	}
	public String getOrbiting_body() {
		return orbiting_body;
	}

    
    
}

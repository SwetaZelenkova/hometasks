package edu.pht.cucumbertestng.beans;

public class ProfileInfo {
	private int bdate_visibility;
	private String home_town;
	private String status;

	public int getBdate_visibility() {
		return bdate_visibility;
	}

	public void setBdate_visibility(int bdate_visibility) {
		this.bdate_visibility = bdate_visibility;
	}

	public String getHome_town() {
		return home_town;
	}

	public void setHome_town(String home_town) {
		this.home_town = home_town;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + bdate_visibility;
		result = prime * result + ((home_town == null) ? 0 : home_town.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProfileInfo other = (ProfileInfo) obj;
		if (bdate_visibility != other.bdate_visibility)
			return false;
		if (home_town == null) {
			if (other.home_town != null)
				return false;
		} else if (!home_town.equals(other.home_town))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ProfileInfo [bdate_visibility=" + bdate_visibility + ", home_town=" + home_town + ", status=" + status
				+ "]";
	}
}

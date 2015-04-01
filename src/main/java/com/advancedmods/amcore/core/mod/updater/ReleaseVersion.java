package com.advancedmods.amcore.core.mod.updater;

import cpw.mods.fml.common.versioning.ArtifactVersion;

public class ReleaseVersion implements ArtifactVersion {

	private final String _label;
	private final int _major;
	private final int _minor;
	private final int _patch;
    private final int _build;
	private final int _rc;
	private final int _beta;
    private final int _alpha;

	public ReleaseVersion(String label, int major, int minor, int patch, int build) {

		this(label, major, minor, patch, build, 0, 0, 0);
	}

	public ReleaseVersion(String label, int major, int minor, int patch, int build, int rc, int beta, int alpha) {

		_label = label;
		_major = major;
		_minor = minor;
		_patch = patch;
        _build = build;
		_rc = rc;
		_beta = beta;
        _alpha = alpha;
	}

	public ReleaseVersion(String label, String s) {

		int major = 0;
		int minor = 0;
		int patch = 0;
        int build = 0;
		int rc = 0;
		int beta = 0;
        int alpha = 0;
		String main = s;
		String[] parts;

		parts = main.split("RC");
		if (parts.length > 1) {
			rc = Integer.parseInt(parts[1]);
            build = Integer.valueOf(parts[1].split("-")[1]);
			main = parts[0];
		}
		parts = main.split("B");
		if (parts.length > 1) {
			beta = Integer.parseInt(parts[1].split("-")[0]);
            build = Integer.valueOf(parts[1].split("-")[1]);
			main = parts[0];
		}
        parts = main.split("A");
        if (parts.length > 1) {
            alpha = Integer.parseInt(parts[1].split("-")[0]);
            build = Integer.valueOf(parts[1].split("-")[1]);
            main = parts[0];
        }
		parts = main.split("\\.");
		switch (parts.length) {

		default:
        case 4:
            build = Integer.parseInt(parts[3]);
        case 3:
			patch = Integer.parseInt(parts[2]);
		case 2:
			minor = Integer.parseInt(parts[1]);
		case 1:
			major = Integer.parseInt(parts[0]);
		case 0:
			break;
		}

		_label = label;
		_major = major;
		_minor = minor;
		_patch = patch;
        _build = build;
		_rc = rc;
		_beta = beta;
        _alpha = alpha;
	}

	public static ReleaseVersion parse(String label, String s) {

		return new ReleaseVersion(label, s);
	}

	public int major() {

		return _major;
	}

	public int minor() {

		return _minor;
	}

	public int patch() {

		return _patch;
	}

    public int build() {

        return _build;
    }

	public int rc() {

		return _rc;
	}

	public int beta() {

		return _beta;
	}

    public int alpha() {

        return _alpha;
    }

	public boolean isStable() {

		return _rc == 0 & _beta == 0;
	}

	public boolean isRC() {

		return _rc > 0;
	}

	public boolean isBeta() {

		return _beta > 0;
	}

    public boolean isAlpha() {

        return _alpha > 0;
    }

	@Override
	public int compareTo(ArtifactVersion o) {

		if (o instanceof ReleaseVersion) {
			return compareTo((ReleaseVersion) o);
		}
		if (o instanceof ModVersion) {
			ModVersion r = (ModVersion) o;
			if (_label.equals(r.getLabel())) {
				return compareTo(r.modVersion());
			} else if ("Minecraft".equals(_label)) {
				return compareTo(r.minecraftVersion());
			}
		}
		return 0;
	}

	public int compareTo(ReleaseVersion arg0) {

		if (this.major() != arg0.major()) {
			return this.major() < arg0.major() ? -1 : 1;
		}
		if (this.minor() != arg0.minor()) {
			return this.minor() < arg0.minor() ? -1 : 1;
		}
		if (this.patch() != arg0.patch()) {
			return this.patch() < arg0.patch() ? -1 : 1;
		}
        if (this.build() != arg0.build()) {
            return this.build() < arg0.build() ? -1 : 1;
        }

		if (this.isStable() && !arg0.isStable()) {
			return 1;
		}
		if (this.isRC() && arg0.isBeta()) {
			return 1;
		}
        if (this.isRC() && arg0.isAlpha()) {
            return 1;
        }
		if (!this.isStable() && arg0.isStable()) {
			return -1;
		}
		if (this.isBeta() && arg0.isRC()) {
			return -1;
		}
        if (this.isAlpha() && arg0.isRC()) {
            return -1;
        }
        if (this.isAlpha() && arg0.isBeta()) {
            return -1;
        }

		if (this.rc() != arg0.rc()) {
			return this.rc() < arg0.rc() ? -1 : 1;
		}
		if (this.beta() != arg0.beta()) {
			return this.beta() < arg0.beta() ? -1 : 1;
		}
        if (this.alpha() != arg0.alpha()) {
            return this.alpha() < arg0.alpha() ? -1 : 1;
        }
		return 0;
	}

	@Override
	public String toString() {

		return _label + " " + getVersionString();
	}

	@Override
	public String getVersionString() {

		String v = _major + "." + _minor + "." + _patch + "." + _build;
		if (_rc != 0) {
			v += "RC" + _rc;
		}
		if (_beta != 0) {
			v += "B" + _beta;
		}
        if (_alpha != 0) {
            v += "A" + _alpha;
        }
		return v;
	}

	@Override
	public String getLabel() {

		return _label;
	}

	@Override
	public boolean containsVersion(ArtifactVersion source) {

		return compareTo(source) == 0;
	}

	@Override
	public String getRangeString() {

		return null;
	}

}

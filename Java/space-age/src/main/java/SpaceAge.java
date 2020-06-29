class SpaceAge {
    private double time;
    private static double secondsEarth =31557600;

    SpaceAge(double seconds) {
        time = seconds;
    }

    double getSeconds() {
        return time;
    }

    double onEarth() {
        return time / secondsEarth;
    }

    double onMercury() {
        return time /(secondsEarth *0.2408467);
    }

    double onVenus() {
        return time /(secondsEarth *0.61519726);
    }

    double onMars() {
        return time /(secondsEarth *1.8808158);
    }

    double onJupiter() {
        return time /(secondsEarth *11.862615);
    }

    double onSaturn() {
        return time /(secondsEarth *29.447498);
    }

    double onUranus() {
        return time /(secondsEarth *84.016846);
    }

    double onNeptune() {
        return time /(secondsEarth *164.79132);
    }

}

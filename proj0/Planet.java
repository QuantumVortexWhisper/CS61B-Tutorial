public class Planet {
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;
    private static final double G = 6.67e-11;

    public Planet(double xP, double yP, double xV,
                  double yV, double m, String img) {
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    };

    public Planet(Planet p) {
        xxPos = p.xxPos;
        yyPos = p.yyPos;
        xxVel = p.xxVel;
        yyVel = p.yyVel;
        mass = p.mass;
        imgFileName = p.imgFileName;
    };

    public double calcDistance(Planet p) {
        double dx = p.xxPos - this.xxPos;
        double dy = p.yyPos - this.yyPos;
        return Math.sqrt(dx * dx + dy * dy);
    };

    public double calcForceExertedBy(Planet p) {
        double dist = calcDistance(p);
        return G * (mass * p.mass) / (dist * dist);
    };

    public double calcForceExertedByX(Planet p) {
        double force = calcForceExertedBy(p);
        return force * (p.xxPos - this.xxPos) / calcDistance(p);
    };

    public double calcForceExertedByY(Planet p) {
        double force = calcForceExertedBy(p);
        return force * (p.yyPos - this.yyPos) / calcDistance(p);
    };

    public double calcNetForceExertedByX(Planet[] allPlanets) {
        double netForceX = 0.0;
        for (Planet p : allPlanets) {
            if (this.equals(p)) {
                continue;
            }

            netForceX += calcForceExertedByX(p);
        }

        return netForceX;
    };

    public double calcNetForceExertedByY(Planet[] allPlanets) {
        double netForceY = 0.0;
        for (Planet p : allPlanets) {
            if (this.equals(p)) {
                continue;
            }

            netForceY += calcForceExertedByY(p);
        }

        return netForceY;
    };

    public void update(double dt, double fX, double fY) {
        double ax = fX / mass;
        double ay = fY / mass;
        xxVel += dt * ax;
        yyVel += dt * ay;
        xxPos += xxVel * dt;
        yyPos += yyVel * dt;
    };

    public void draw() {
        StdDraw.picture(xxPos, yyPos, "./images/" + imgFileName);
    }
}

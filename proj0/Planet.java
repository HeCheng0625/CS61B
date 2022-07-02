public class Planet {
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;
    public static final double G = 6.67e-11;

    public Planet(double xP, double yP, double xV, double yV, double m, String img) {
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }

    public Planet(Planet p) {
        xxPos = p.xxPos;
        yyPos = p.yyPos;
        xxVel = p.xxVel;
        yyVel = p.yyVel;
        mass = p.mass;
        imgFileName = p.imgFileName;
    }

    public double calcDistance(Planet p) {
        return Math.sqrt((xxPos - p.xxPos)*(xxPos - p.xxPos) + (yyPos - p.yyPos)*(yyPos - p.yyPos));
    }

    public double calcForceExertedBy(Planet p) {
        double r = calcDistance(p);
        return G * p.mass * mass / (r * r);
    }

    public double calcForceExertedByX(Planet p) {
        double r = calcDistance(p);
        double F = calcForceExertedBy(p);
        return F * (p.xxPos - xxPos) / r;
    }

    public double calcForceExertedByY(Planet p) {
        double r = calcDistance(p);
        double F = calcForceExertedBy(p);
        return F * (p.yyPos - yyPos) / r;
    }

    public double calcNetForceExertedByX(Planet[] allPlanets) {
        double fX = 0;
        for (Planet p: allPlanets) {
            if (this.equals(p)) continue;
            fX += calcForceExertedByX(p);
        }
        return fX;
    }

    public double calcNetForceExertedByY(Planet[] allPlanets) {
        double fY = 0;
        for (Planet p: allPlanets) {
            if (this.equals(p)) continue;
            fY += calcForceExertedByY(p);
        }
        return fY;
    }

    public void update(double dt, double fX, double fY) {
        xxVel += dt * fX / mass;
        yyVel += dt * fY / mass;
        xxPos += xxVel * dt;
        yyPos += yyVel * dt;
    }
}
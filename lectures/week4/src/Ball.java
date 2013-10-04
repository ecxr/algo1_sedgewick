/**
 * Created by sky on 10/2/13.
 */
public class Ball
{
    private double rx, ry;          // position
    private double vx, vy;          // velocity
    private final double radius;    // radius

    public Ball()
    {
        // initialize pos and vel
        radius = 1.0;
    }

    public void move(double dt)
    {
        // check for collision with walls
        if ((rx + vx*dt < radius) || (rx + vx*dt > 1.0 - radius))
        {
            vx = -vx;
        }
        if ((ry + vy*dt < radius) || (ry + vy*dt > 1.0 - radius))
        {
            vy = -vy;
        }
        rx = rx + vx*dt;
        ry = ry + vy*dt;
    }

    public void draw()
    {
        StdDraw.filledCircle(rx, ry, radius);
    }
}

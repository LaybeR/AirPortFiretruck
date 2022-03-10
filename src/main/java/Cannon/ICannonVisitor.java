package Cannon;

public interface ICannonVisitor {
    boolean visit(FrontCannon cannon);
    boolean visit(RoofCannon cannon);
    boolean visit(FloorCannon cannon);
}

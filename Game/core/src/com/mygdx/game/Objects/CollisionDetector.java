package com.mygdx.game.Objects;

import com.mygdx.game.Objects.GameObject;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Intersector;
import com.mygdx.game.Objects.GameObject;
import com.mygdx.game.Objects.Building;
import com.mygdx.game.Objects.PlayerController;

import java.util.List;

public class CollisionDetector {
    private List<GameObject> objects;

    public void registerObjects(List<GameObject> objects) {
        this.objects = objects;
    }

    public void detectCollisions() {
        if (objects == null) return;

        for (GameObject obj1 : objects) {
            for (GameObject obj2 : objects) {
                if (obj1 != obj2 && obj1.bounds.overlaps(obj2.bounds)) {
                    handleCollision(obj1, obj2);
                }
            }
        }
    }

    private void handleCollision(GameObject obj1, GameObject obj2) {
        // Player + Building collision
        if (obj1 instanceof PlayerController && obj2 instanceof Building) {
            PlayerController player = (PlayerController) obj1;
            Building building = (Building) obj2;
            // Stop player movement and enable an interaction

        }

        else if (obj1 instanceof Building && obj2 instanceof PlayerController) {
            handleCollision(obj2, obj1);
        }
    }
}

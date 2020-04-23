(ns hodur-example-app.visualizer
  (:require [hodur-engine.core :as engine]
            [hodur-example-app.schemas :as schemas]
            [hodur-visualizer-schema.core :as visualizer]))

(comment
  (def meta-db
    (engine/init-schema schemas/shared
                        schemas/lacinia-pagination
                        schemas/lacinia-query)))

(def meta-db (engine/init-schema
              '[Person
                [^String first-name
                 ^String last-name
                 ^String pet
                 ^Gender gender]

                ^:enum
                Gender
                [MALE FEMALE IRRELEVANT]]))

(-> meta-db
    visualizer/schema
    visualizer/apply-diagram!)

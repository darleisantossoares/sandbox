(ns sandbox.db.datomic.playground
  (:require [datomic.api :as d]))

(def db-uri "datomic:dev://localhost:4334/sandbox")

(d/create-database db-uri)

(def conn (d/connect db-uri))

@(d/transact conn [{:db/doc "Hello World"}])

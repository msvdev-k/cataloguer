-- ----------------------------------------------------------------- --
-- Схема базы данных каталогизатора на языке SQL диалекта PostgreSQL --
-- ----------------------------------------------------------------- --


CREATE TABLE "users" (
    "id"        BIGSERIAL   PRIMARY KEY,
    "email"     VARCHAR(64) NOT NULL,
    "password"  VARCHAR(60) NOT NULL,

    CONSTRAINT "users_email_unique" UNIQUE ("email")
);


CREATE TABLE "catalogs" (
    "id"            BIGSERIAL   PRIMARY KEY,
    "admin_id"      BIGINT      NOT NULL,
    "name"          TEXT        NOT NULL,
    "name_lower"    TEXT        GENERATED ALWAYS AS (lower("name")) STORED,
    "description"   TEXT        NULL,
    "created"       TIMESTAMP   DEFAULT CURRENT_TIMESTAMP,

    CONSTRAINT "catalogs_name_unique"
        UNIQUE ("admin_id", "name_lower"),
    
    CONSTRAINT "catalogs_admin_id"
        FOREIGN KEY ("admin_id") REFERENCES "users" ("id")
        ON DELETE RESTRICT
);



CREATE TYPE "colleague_role" AS ENUM ('read', 'write', 'all');

CREATE TABLE "colleagues" (
    "user_id"     BIGINT,
    "catalog_id"  BIGINT,
    "role"        "colleague_role"  DEFAULT 'read',
    
    PRIMARY KEY ("user_id", "catalog_id"),
    
    CONSTRAINT "colleagues_user_id"
        FOREIGN KEY ("user_id") REFERENCES "users" ("id")
        ON DELETE RESTRICT,
    
    CONSTRAINT "colleagues_catalog_id"
        FOREIGN KEY ("catalog_id") REFERENCES "catalogs" ("id")
        ON DELETE RESTRICT    
);


CREATE TYPE "field_type"    AS ENUM ('str', 'int', 'long', 'bool', 'double');
CREATE TYPE "field_format"  AS ENUM ();

CREATE TABLE "field_templates" (
    "id"            BIGSERIAL       PRIMARY KEY,
    "name"          TEXT            NOT NULL,
    "description"   TEXT            NULL,
    "type"          "field_type"    DEFAULT 'str',
    "format"        "field_format"  NULL    
);


CREATE TABLE "catalog_field_templates" (
    "catalog_id"         BIGINT,
    "field_template_id"  BIGINT,
    
    PRIMARY KEY ("catalog_id", "field_template_id"),
    
    CONSTRAINT "catalog_field_templates_catalog_id"
        FOREIGN KEY ("catalog_id") REFERENCES "catalogs" ("id")
        ON DELETE RESTRICT,

    CONSTRAINT "catalog_field_templates_user_id"
        FOREIGN KEY ("field_template_id") REFERENCES "field_templates" ("id")
        ON DELETE RESTRICT    
);


CREATE TABLE "field_values" (
    "id"            BIGSERIAL   PRIMARY KEY,
    "template_id"   BIGINT      NOT NULL,
    "str"           TEXT        NULL,
    "int"           INTEGER     NULL,
    "long"          BIGINT      NULL,
    "bool"          BOOLEAN     NULL,
    "double"        FLOAT8      NULL,
    
    CONSTRAINT "field_values_template_id"
        FOREIGN KEY ("template_id") REFERENCES "field_templates" ("id")
        ON DELETE RESTRICT    
);


CREATE TABLE "cards" (
    "id"         BIGSERIAL   PRIMARY KEY,
    "created"    TIMESTAMP   DEFAULT CURRENT_TIMESTAMP
);


CREATE TABLE "catalog_cards" (
    "catalog_id"    BIGINT,
    "card_id"       BIGINT,
    
    PRIMARY KEY ("catalog_id", "card_id"),
    
    CONSTRAINT "catalog_cards_catalog_id"
        FOREIGN KEY ("catalog_id") REFERENCES "catalogs" ("id")
        ON DELETE RESTRICT,

    CONSTRAINT "catalog_cards_card_id"
        FOREIGN KEY ("card_id") REFERENCES "cards" ("id")
        ON DELETE RESTRICT    
);


CREATE TABLE "card_fields" (
    "card_id"   BIGINT,
    "value_id"  BIGINT,
    
    PRIMARY KEY ("card_id", "value_id"),
    
    CONSTRAINT "card_fields_card_id"
        FOREIGN KEY ("card_id") REFERENCES "cards" ("id")
        ON DELETE RESTRICT,

    CONSTRAINT "card_fields_value_id"
        FOREIGN KEY ("value_id") REFERENCES "field_values" ("id")
        ON DELETE RESTRICT    
);

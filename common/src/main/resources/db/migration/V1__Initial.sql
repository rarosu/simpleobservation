CREATE TABLE habitat (
    id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (INCREMENT 1 START 1),
    parent_habitat_id INTEGER NULL REFERENCES habitat(id),
    swedish_name TEXT NOT NULL,
    CONSTRAINT habitat_pkey PRIMARY KEY(id)
);

CREATE TABLE taxon (
    id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY(INCREMENT 1 START 1),
    dyntaxa_id INTEGER NOT NULL,
    parent_taxon_id INTEGER NULL REFERENCES taxon(id),
    ranking INTEGER NOT NULL,
    scientific_name TEXT NOT NULL,
    swedish_name TEXT NOT NULL,
    CONSTRAINT taxon_pkey PRIMARY KEY(id)
);

CREATE TABLE observation_list (
    id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY(INCREMENT 1 START 1),
    longitude DOUBLE PRECISION NULL,
    latitude DOUBLE PRECISION NULL,
    coordinate_precision INTEGER NULL,
    location_name TEXT NULL,
    list_name TEXT NOT NULL,
    private_comment TEXT NULL,
    public_comment TEXT NULL,
    creation_date_time TIMESTAMP WITH TIME ZONE NOT NULL,
    observation_date_time TIMESTAMP WITH TIME ZONE NULL,
    habitat_id INTEGER NULL REFERENCES habitat(id),
    habitat_description TEXT NULL,
    CONSTRAINT observation_list_pkey PRIMARY KEY(id)
);

CREATE TABLE observation (
    id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY(INCREMENT 1 START 1),
    taxon_id INTEGER NOT NULL REFERENCES taxon(id),
    observation_list_id INTEGER NOT NULL REFERENCES observation_list(id),
    longitude DOUBLE PRECISION NULL,
    latitude DOUBLE PRECISION NULL,
    coordinate_precision INTEGER NULL,
    location_name TEXT NULL,
    private_comment TEXT NULL,
    public_comment TEXT NULL,
    creation_date_time TIMESTAMP WITH TIME ZONE NOT NULL,
    observation_date_time TIMESTAMP WITH TIME ZONE NULL,
    sex INTEGER NULL,
    individual_count INTEGER NULL,
    individual_count_measure INTEGER NULL,
    age_stage INTEGER NULL,
    is_found BOOLEAN NOT NULL,
    habitat_id INTEGER NULL REFERENCES habitat(id),
    habitat_description TEXT NULL,
    host_taxon_id INTEGER NULL REFERENCES taxon(id),
    CONSTRAINT observation_pkey PRIMARY KEY(id)
);
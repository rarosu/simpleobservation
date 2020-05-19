# Simple Observation

**WIP: This project is under development**

Simple Observation is an app made to teach myself java development practices and to have an app for noting wild vascular plants I encounter for a later import into [artportalen](https://artportalen.se/).

The major technologies used are the Android SDK, Gradle, Spring Boot and JPA/Hibernate. The application is built on top of PostgreSQL.

## Building

The project is made as a gradle multi-project. To build the components, run the following command in the repository root:

`gradlew build`

## Running and Debugging

To run or debug the service, run the following command:

`gradlew service:bootRun`

To debug the app, run the following command install it on an emulator or connected phone:

`gradlew app:installDebug`

To run the taxa import tool and fill the database with taxa, first download a list of the taxa from [dyntaxa](https://www.dyntaxa.se/Export/TaxonList/0). Select "Plantae -> Viridiplantae -> Streptophyta -> Embryophyta -> Tracheophyta" from the menu on the left. Open the "Taxoninformation" tab and make sure the following options are checked:
- Vetenskapligt namn
- Svenskt namn
- Taxonkategori
- TaxonId

Click on "Skapa excelfil" and an excel file with the swedish taxa will be downloaded. Run:

`gradlew tools:taxaimporter:installDist`

Run the generated script in the `tools/taxaimporter/build/install/taxaimporter/bin` directory with the command line argument pointing to the downloaded excel file.

## Deploying

No deployment instructions available yet.

## Testing

No testing instructions available yet.
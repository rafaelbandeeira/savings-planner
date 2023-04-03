### Saving Planner Automated Check
This project contains one automated check that aims to observe and check for one of the risks identified for the product,
which is the inaccurate floating point calculation that is natural to computer processors. Given the nature of the
feature, which is financial, floating point calculation is unavoidable.

### Necessary Steps
* Install Maven (3.9 or above)
* OpenJDK (preferably 17.0.1 or above)
* It can be reproduced on a pipeline by running the commant `mvn clean test`

### Extra Notes
The project was prepared to be run on more than one environment by simply setting an `ENV` environment variable and
adding the URL to the desired environment in the `config.App` class.
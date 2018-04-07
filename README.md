# HugoHealth Crypto Checker

Simple JAVA application for getting the current price and market cap of a crypto currency.
Uses CryptoMarketCap REST API to gather the ticker information for the given currency.
Simple dockerfile (./'Dockerfile') has been provided.

## Prerequisites

'''
Java
Docker
'''

## How To Run

1) Go to the project directory.

2) Build the project
'''
./gradlew build
'''
3) Create a Docker image
'''
docker build -t "<tag_name>" .
'''

4) Run the image
'''
docker run <tag_name> <crypto_cyrrency_symbol>
'''
	NOTE: The program requires the argument "<crypto_cyrrency_symbol>" to be set!
	
### Example

'''
./gradle clean build
docker build -t "hugo-crypo" .
docker run hugo-crypto bitcoin
'''
	
## Built With

* [Eclipse](https://www.eclipse.org)
* [Gradle Eclipse Plugin](https://docs.gradle.org/current/userguide/eclipse_plugin.html)
* [JSON In Java](https://mvnrepository.com/artifact/org.json/json)
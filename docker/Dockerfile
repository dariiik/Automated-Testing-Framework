FROM python:3.8 

WORKDIR /app 

COPY requirements.text . 

RUN pip install -r requirements.txt 

RUN pip install selenium

RUN apt-get update && apt-get install -y opendjdk-11-jdk 

RUN apt-get install -y maven 

COPY test_data/ /app/test_data

COPY pom.xml . 

RUN mvn clean install -DskipTests

ENV TEST_DB_URL = 
ENV API_ENDPOINT = 

COPY . . /app/

CMD ["pytest"]

EXPOSE 8000 




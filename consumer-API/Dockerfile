FROM gradle:7.6.0-jdk17
COPY --chown=gradle:gradle . .
WORKDIR .
RUN gradle build -x test --no-daemon #dar build na aplicação excluindo o teste e o build do daemon
EXPOSE 8082
CMD ["gradle", "bootRun"]

#criar essa imagem
    # comando ->     docker image build build -t consumer-api

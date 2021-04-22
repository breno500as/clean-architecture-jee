FROM breno500as/wildfly21openjdk11

COPY files/*.sh /usr/local/bin/
COPY files/zips/*.zip /tmp/
COPY files/standalone.xml /tmp/

ARG MANAGEMENT_USERNAME
ARG MANAGEMENT_PASSWORD

ENV MANAGEMENT_USERNAME ${MANAGEMENT_USERNAME:-"admin"}
ENV MANAGEMENT_PASSWORD ${MANAGEMENT_PASSWORD:-"password"}

ADD sipu.ear $JBOSS_HOME/standalone/deployments

ADD files/*.cer /tmp/

USER root

RUN apt update \
  && apt install -y unzip \
  && unzip /tmp/postgresql-module.zip -d ${JBOSS_HOME} \
  && unzip /tmp/oracle-module.zip -d ${JBOSS_HOME} \
  && rm -rf ${JBOSS_HOME}/modules/system/layers/base/org/apache/httpcomponents \
  && unzip -o /tmp/httpcomponents-module.zip -d ${JBOSS_HOME} \
  && yes | cp -rf /tmp/standalone.xml ${JBOSS_HOME}/standalone/configuration/ \
  && chmod 755 /usr/local/bin/*.sh \
  && chown jboss:jboss $JBOSS_HOME -R \
  && chmod 755 $JBOSS_HOME -R \
  && keytool -v -import -noprompt -trustcacerts -alias pbh.gov.br -file /tmp/pbh.gov.br.cer -keystore /usr/lib/jvm/jre/lib/security/cacerts -storepass changeit \
  && keytool -v -import -noprompt -trustcacerts -alias pbh-gov-br -file /tmp/pbh-gov-br.cer -keystore /usr/lib/jvm/jre/lib/security/cacerts -storepass changeit \
  && keytool -v -import -noprompt -trustcacerts -alias pbhgovbr2 -file /tmp/certificado.cer -keystore /usr/lib/jvm/jre/lib/security/cacerts -storepass changeit \
  && echo 'JAVA_OPTS="$JAVA_OPTS -Duser.language=pt -Duser.country=BR -Dfile.encoding=UTF8"' >> $JBOSS_HOME/bin/standalone.conf \
  && echo 'JAVA_OPTS="$JAVA_OPTS -Xms1024m -Xmx4096m -XX:MetaspaceSize=96M -XX:MaxMetaspaceSize=512m"' >> $JBOSS_HOME/bin/standalone.conf

ENTRYPOINT [ "/usr/local/bin/entrypoint.sh"]


@rem
@rem Copyright 2015 the original author or authors.
@rem
@rem Licensed under the Apache License, Version 2.0 (the "License");
@rem you may not use this file except in compliance with the License.
@rem You may obtain a copy of the License at
@rem
@rem      https://www.apache.org/licenses/LICENSE-2.0
@rem
@rem Unless required by applicable law or agreed to in writing, software
@rem distributed under the License is distributed on an "AS IS" BASIS,
@rem WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
@rem See the License for the specific language governing permissions and
@rem limitations under the License.
@rem
@rem SPDX-License-Identifier: Apache-2.0
@rem

@if "%DEBUG%"=="" @echo off
@rem ##########################################################################
@rem
@rem  notification-engine startup script for Windows
@rem
@rem ##########################################################################

@rem Set local scope for the variables with windows NT shell
if "%OS%"=="Windows_NT" setlocal

set DIRNAME=%~dp0
if "%DIRNAME%"=="" set DIRNAME=.
@rem This is normally unused
set APP_BASE_NAME=%~n0
set APP_HOME=%DIRNAME%..

@rem Resolve any "." and ".." in APP_HOME to make it shorter.
for %%i in ("%APP_HOME%") do set APP_HOME=%%~fi

@rem Add default JVM options here. You can also use JAVA_OPTS and NOTIFICATION_ENGINE_OPTS to pass JVM options to this script.
set DEFAULT_JVM_OPTS=

@rem Find java.exe
if defined JAVA_HOME goto findJavaFromJavaHome

set JAVA_EXE=java.exe
%JAVA_EXE% -version >NUL 2>&1
if %ERRORLEVEL% equ 0 goto execute

echo. 1>&2
echo ERROR: JAVA_HOME is not set and no 'java' command could be found in your PATH. 1>&2
echo. 1>&2
echo Please set the JAVA_HOME variable in your environment to match the 1>&2
echo location of your Java installation. 1>&2

goto fail

:findJavaFromJavaHome
set JAVA_HOME=%JAVA_HOME:"=%
set JAVA_EXE=%JAVA_HOME%/bin/java.exe

if exist "%JAVA_EXE%" goto execute

echo. 1>&2
echo ERROR: JAVA_HOME is set to an invalid directory: %JAVA_HOME% 1>&2
echo. 1>&2
echo Please set the JAVA_HOME variable in your environment to match the 1>&2
echo location of your Java installation. 1>&2

goto fail

:execute
@rem Setup the command line

set CLASSPATH=%APP_HOME%\lib\notification-engine-0.0.1-SNAPSHOT-plain.jar;%APP_HOME%\lib\multitenant-0.0.1-SNAPSHOT-plain.jar;%APP_HOME%\lib\core-0.0.1-SNAPSHOT-plain.jar;%APP_HOME%\lib\spring-boot-starter-websocket-3.3.4.jar;%APP_HOME%\lib\spring-boot-starter-web-3.3.4.jar;%APP_HOME%\lib\spring-boot-starter-validation-3.3.4.jar;%APP_HOME%\lib\spring-boot-starter-amqp-3.3.4.jar;%APP_HOME%\lib\spring-boot-starter-mail-3.3.4.jar;%APP_HOME%\lib\spring-boot-starter-security-3.3.4.jar;%APP_HOME%\lib\spring-boot-starter-actuator-3.3.4.jar;%APP_HOME%\lib\spring-boot-starter-json-3.3.4.jar;%APP_HOME%\lib\spring-boot-starter-data-jpa-3.3.4.jar;%APP_HOME%\lib\spring-boot-starter-aop-3.3.4.jar;%APP_HOME%\lib\spring-boot-starter-jdbc-3.3.4.jar;%APP_HOME%\lib\spring-boot-starter-3.3.4.jar;%APP_HOME%\lib\spring-boot-starter-jetty-3.3.4.jar;%APP_HOME%\lib\spring-boot-devtools-3.3.4.jar;%APP_HOME%\lib\jjwt-jackson-0.11.5.jar;%APP_HOME%\lib\spring-boot-actuator-autoconfigure-3.3.4.jar;%APP_HOME%\lib\jackson-datatype-jdk8-2.17.2.jar;%APP_HOME%\lib\springdoc-openapi-starter-webmvc-ui-2.2.0.jar;%APP_HOME%\lib\springdoc-openapi-starter-webmvc-api-2.2.0.jar;%APP_HOME%\lib\springdoc-openapi-starter-common-2.2.0.jar;%APP_HOME%\lib\swagger-core-jakarta-2.2.15.jar;%APP_HOME%\lib\jackson-datatype-jsr310-2.17.2.jar;%APP_HOME%\lib\jackson-module-parameter-names-2.17.2.jar;%APP_HOME%\lib\jackson-dataformat-yaml-2.17.2.jar;%APP_HOME%\lib\jackson-databind-2.17.2.jar;%APP_HOME%\lib\jackson-core-2.17.2.jar;%APP_HOME%\lib\swagger-models-jakarta-2.2.15.jar;%APP_HOME%\lib\jackson-annotations-2.17.2.jar;%APP_HOME%\lib\jjwt-impl-0.11.5.jar;%APP_HOME%\lib\jjwt-api-0.11.5.jar;%APP_HOME%\lib\commons-text-1.11.0.jar;%APP_HOME%\lib\commons-lang3-3.14.0.jar;%APP_HOME%\lib\modelmapper-3.1.1.jar;%APP_HOME%\lib\mysql-connector-j-8.3.0.jar;%APP_HOME%\lib\spring-data-envers-3.3.4.jar;%APP_HOME%\lib\spring-boot-autoconfigure-3.3.4.jar;%APP_HOME%\lib\spring-boot-actuator-3.3.4.jar;%APP_HOME%\lib\spring-boot-3.3.4.jar;%APP_HOME%\lib\spring-boot-starter-logging-3.3.4.jar;%APP_HOME%\lib\spring-boot-starter-tomcat-3.3.4.jar;%APP_HOME%\lib\spring-data-jpa-3.3.4.jar;%APP_HOME%\lib\jetty-ee10-websocket-jakarta-server-12.0.13.jar;%APP_HOME%\lib\jetty-ee10-websocket-jetty-server-12.0.13.jar;%APP_HOME%\lib\jetty-ee10-annotations-12.0.13.jar;%APP_HOME%\lib\jetty-ee10-plus-12.0.13.jar;%APP_HOME%\lib\jakarta.enterprise.cdi-api-4.0.1.jar;%APP_HOME%\lib\jakarta.interceptor-api-2.1.0.jar;%APP_HOME%\lib\jakarta.annotation-api-2.1.1.jar;%APP_HOME%\lib\spring-webmvc-6.1.13.jar;%APP_HOME%\lib\spring-security-web-6.3.3.jar;%APP_HOME%\lib\spring-websocket-6.1.13.jar;%APP_HOME%\lib\spring-web-6.1.13.jar;%APP_HOME%\lib\spring-rabbit-3.1.7.jar;%APP_HOME%\lib\spring-messaging-6.1.13.jar;%APP_HOME%\lib\spring-context-support-6.1.13.jar;%APP_HOME%\lib\spring-security-config-6.3.3.jar;%APP_HOME%\lib\spring-security-core-6.3.3.jar;%APP_HOME%\lib\spring-context-6.1.13.jar;%APP_HOME%\lib\spring-aop-6.1.13.jar;%APP_HOME%\lib\spring-orm-6.1.13.jar;%APP_HOME%\lib\spring-jdbc-6.1.13.jar;%APP_HOME%\lib\spring-data-commons-3.3.4.jar;%APP_HOME%\lib\spring-tx-6.1.13.jar;%APP_HOME%\lib\spring-beans-6.1.13.jar;%APP_HOME%\lib\spring-expression-6.1.13.jar;%APP_HOME%\lib\spring-amqp-3.1.7.jar;%APP_HOME%\lib\spring-core-6.1.13.jar;%APP_HOME%\lib\snakeyaml-2.2.jar;%APP_HOME%\lib\hibernate-envers-6.5.3.Final.jar;%APP_HOME%\lib\hibernate-core-6.5.3.Final.jar;%APP_HOME%\lib\spring-aspects-6.1.13.jar;%APP_HOME%\lib\tomcat-embed-el-10.1.30.jar;%APP_HOME%\lib\hibernate-validator-8.0.1.Final.jar;%APP_HOME%\lib\jakarta.mail-2.0.3.jar;%APP_HOME%\lib\micrometer-jakarta9-1.13.4.jar;%APP_HOME%\lib\micrometer-core-1.13.4.jar;%APP_HOME%\lib\micrometer-observation-1.13.4.jar;%APP_HOME%\lib\jetty-ee10-webapp-12.0.13.jar;%APP_HOME%\lib\jetty-ee10-websocket-servlet-12.0.13.jar;%APP_HOME%\lib\jetty-ee10-servlet-12.0.13.jar;%APP_HOME%\lib\jakarta.servlet-api-6.0.0.jar;%APP_HOME%\lib\jetty-ee10-websocket-jakarta-client-12.0.13.jar;%APP_HOME%\lib\jetty-ee10-websocket-jakarta-common-12.0.13.jar;%APP_HOME%\lib\jakarta.websocket-api-2.1.1.jar;%APP_HOME%\lib\jakarta.websocket-client-api-2.1.1.jar;%APP_HOME%\lib\jetty-ee10-servlets-12.0.13.jar;%APP_HOME%\lib\logback-classic-1.5.8.jar;%APP_HOME%\lib\log4j-to-slf4j-2.23.1.jar;%APP_HOME%\lib\jul-to-slf4j-2.0.16.jar;%APP_HOME%\lib\HikariCP-5.1.0.jar;%APP_HOME%\lib\amqp-client-5.21.0.jar;%APP_HOME%\lib\jetty-ee-12.0.13.jar;%APP_HOME%\lib\jetty-session-12.0.13.jar;%APP_HOME%\lib\jetty-plus-12.0.13.jar;%APP_HOME%\lib\jetty-security-12.0.13.jar;%APP_HOME%\lib\jetty-websocket-core-server-12.0.13.jar;%APP_HOME%\lib\jetty-server-12.0.13.jar;%APP_HOME%\lib\jetty-websocket-core-client-12.0.13.jar;%APP_HOME%\lib\jetty-client-12.0.13.jar;%APP_HOME%\lib\jetty-websocket-jetty-common-12.0.13.jar;%APP_HOME%\lib\jetty-websocket-core-common-12.0.13.jar;%APP_HOME%\lib\jetty-http-12.0.13.jar;%APP_HOME%\lib\jetty-alpn-client-12.0.13.jar;%APP_HOME%\lib\jetty-io-12.0.13.jar;%APP_HOME%\lib\jetty-xml-12.0.13.jar;%APP_HOME%\lib\jetty-util-12.0.13.jar;%APP_HOME%\lib\slf4j-api-2.0.16.jar;%APP_HOME%\lib\swagger-ui-5.2.0.jar;%APP_HOME%\lib\spring-jcl-6.1.13.jar;%APP_HOME%\lib\tomcat-embed-websocket-10.1.30.jar;%APP_HOME%\lib\tomcat-embed-core-10.1.30.jar;%APP_HOME%\lib\aspectjweaver-1.9.22.1.jar;%APP_HOME%\lib\jakarta.persistence-api-3.1.0.jar;%APP_HOME%\lib\jakarta.transaction-api-2.0.1.jar;%APP_HOME%\lib\jboss-logging-3.5.3.Final.jar;%APP_HOME%\lib\hibernate-commons-annotations-6.0.6.Final.jar;%APP_HOME%\lib\jandex-3.1.2.jar;%APP_HOME%\lib\classmate-1.7.0.jar;%APP_HOME%\lib\byte-buddy-1.14.19.jar;%APP_HOME%\lib\jaxb-runtime-4.0.5.jar;%APP_HOME%\lib\jaxb-core-4.0.5.jar;%APP_HOME%\lib\jakarta.xml.bind-api-4.0.2.jar;%APP_HOME%\lib\jakarta.inject-api-2.0.1.jar;%APP_HOME%\lib\antlr4-runtime-4.13.0.jar;%APP_HOME%\lib\jakarta.validation-api-3.0.2.jar;%APP_HOME%\lib\angus-activation-2.0.2.jar;%APP_HOME%\lib\jakarta.activation-api-2.1.3.jar;%APP_HOME%\lib\micrometer-commons-1.13.4.jar;%APP_HOME%\lib\jetty-websocket-jetty-api-12.0.13.jar;%APP_HOME%\lib\logback-core-1.5.8.jar;%APP_HOME%\lib\log4j-api-2.23.1.jar;%APP_HOME%\lib\spring-retry-2.0.9.jar;%APP_HOME%\lib\spring-security-crypto-6.3.3.jar;%APP_HOME%\lib\HdrHistogram-2.2.2.jar;%APP_HOME%\lib\LatencyUtils-2.0.3.jar;%APP_HOME%\lib\asm-commons-9.7.jar;%APP_HOME%\lib\asm-tree-9.7.jar;%APP_HOME%\lib\asm-9.7.jar;%APP_HOME%\lib\txw2-4.0.5.jar;%APP_HOME%\lib\istack-commons-runtime-4.1.2.jar;%APP_HOME%\lib\jakarta.enterprise.lang-model-4.0.1.jar;%APP_HOME%\lib\swagger-annotations-jakarta-2.2.15.jar


@rem Execute notification-engine
"%JAVA_EXE%" %DEFAULT_JVM_OPTS% %JAVA_OPTS% %NOTIFICATION_ENGINE_OPTS%  -classpath "%CLASSPATH%" com.retrowalk.NotificationEngine %*

:end
@rem End local scope for the variables with windows NT shell
if %ERRORLEVEL% equ 0 goto mainEnd

:fail
rem Set variable NOTIFICATION_ENGINE_EXIT_CONSOLE if you need the _script_ return code instead of
rem the _cmd.exe /c_ return code!
set EXIT_CODE=%ERRORLEVEL%
if %EXIT_CODE% equ 0 set EXIT_CODE=1
if not ""=="%NOTIFICATION_ENGINE_EXIT_CONSOLE%" exit %EXIT_CODE%
exit /b %EXIT_CODE%

:mainEnd
if "%OS%"=="Windows_NT" endlocal

:omega

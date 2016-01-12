/*
   For step-by-step instructions on connecting your Android application to this backend module,
   see "App Engine Java Endpoints Module" template documentation at
   https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloEndpoints
*/

package com.seliverstov.jokesbackend;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.seliverstov.jokes.Jokes;

import javax.inject.Named;

/** An endpoint class we are exposing */
@Api(
  name = "jokesApi",
  version = "v1",
  namespace = @ApiNamespace(
    ownerDomain = "jokesbackend.seliverstov.com",
    ownerName = "jokesbackend.seliverstov.com",
    packagePath=""
  )
)
public class JokeEndpoint {

    /** A simple endpoint method that takes a name and says Hi back */
    @ApiMethod(name = "getJoke")
    public JokeBean getJoke() {
        JokeBean response = new JokeBean();
        response.setText(Jokes.getRandomJoke());
        return response;
    }

}

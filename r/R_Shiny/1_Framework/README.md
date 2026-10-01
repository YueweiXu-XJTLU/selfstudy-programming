# Shiny Framework

-   basic elements:
    1.  ui (前端)
    2.  server (后端)

------------------------------------------------------------------------

-   framework types:
    1.  single file version: contain ui & server in the main file
    2.  multiple file version: use ui.R & server.R in the work directory (**do not** change the file names)

------------------------------------------------------------------------

-   further customization:
    1.  use `app <- shinyApp(ui, server)` + `runApp(app, display.mode = "showcase", ...)` instaed of `shinyApp(ui, server)`
    2.  create a file `DESCRIPTION` in workdirectory and add attributes, such as `DisplayMode: Showcase`

------------------------------------------------------------------------

-   directories:
    -   upon run app, the directory for app.R will be root directory automatically

------------------------------------------------------------------------

-   program run and performance
    -   Code outside `server` runs when the app starts
    -   `server` runs each time a user visits app --\> define user specific objects here (server but out of render*)

    -   `render*` functions run each time a user change the value of a widget --\> only place code that Shiny must rerun to build an object here (render* in server)

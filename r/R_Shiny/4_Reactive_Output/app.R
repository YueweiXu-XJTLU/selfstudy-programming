library(shiny)
library(bslib)
library(bsicons)

ui <- fluidPage(
  theme = bs_theme(),
  
  h1("Reactive Output"),
  
  card(
    markdown("
    # Two Steps:
    1. Add an R object to the UI (Output function)
    2. Provide R code to build the object in Server (Render function)
    
    ---
             "),
    
    markdown("
    | Output function | Creates |
    |--------------------|----------|
    | `dataTableOutput` | DataTable |
    | `htmlOutput` | raw HTML |
    | `imageOutput` | image |
    | `plotOutput` | plot |
    | `tableOutput` | table |
    | `textOutput` | text |
    | `uiOutput` | raw HTML |
    | `verbatimTextOutput` | text |
    
    > Each of the `*Output` functions require a single argument (a character string used as the name of this reactive element)
    
    ---
             "),
    
    markdown("
    | Render function | Creates |
    |-----------------|----------|
    | `renderDataTable` | DataTable |
    | `renderImage` | images (saved as a link to a source file) |
    | `renderPlot` | plots |
    | `renderPrint` | any printed output |
    | `renderTable` | data frame, matrix, other table like structures |
    | `renderText` | character strings |
    | `renderUI` | a Shiny tag object or HTML |
    ")
    ),
  
  card(
    h1("Example:"),
    
    sliderInput(
      "slider",
      "Set value range",
      min = 0,
      max = 100,
      value = c(25, 75)
    ),
    
    textOutput("text_output")
  )
  
)

server <- function(input, output, session) {
  # no need to return manually
  output$text_output <- renderText(
    {
      paste("Your chosen range:", input$slider[1], "to", input$slider[2])
    }
  )
}

shinyApp(ui, server)

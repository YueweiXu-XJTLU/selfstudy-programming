library(shiny)
library(bslib)
library(bsicons)

# specialized sidebar layout
# ui <- page_sidebar(
#   title = "title panel",
#   sidebar = sidebar("Sidebar", position = "right"),
#   "Main contents"
# )

ui <- page_fluid(
  h1("Title Panel"),
  
  layout_sidebar(
    sidebar = sidebar("Sidebar Penal", position = "left"),
    "Main Panel"
  ),
  
  card(
    card_header(
      "Card Header"
    ),
    
    markdown("*Card Body*"),
    markdown("`code format 1`"),
    code("code format2"),
    
    card_image("www/img.png", height = "500px"), 
    
    card_footer(
      "Card Footer"
    )
  ),
  
  value_box(
    title = "Value Box",
    value = 666.66,
    p("a component to highlight numbers"),
    showcase = bsicons::bs_icon("bar-chart"),
    theme = "teal"
  )
)

server <- function(input, output, session) {
  
}

app <- shinyApp(ui, server)
runApp(app)


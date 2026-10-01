library(shiny)
library(bslib)
library(bsicons)

ui <- fluidPage(
  card(
    titlePanel("Basic widgets"),
    
    markdown("
    | `function` | widget |
    |-------------|--------|
    | `actionButton` | Action Button |
    | `checkboxGroupInput` | A group of check boxes |
    | `checkboxInput` | A single check box |
    | `dateInput` | A calendar to aid date selection |
    | `dateRangeInput` | A pair of calendars for selecting a date range |
    | `fileInput` | A file upload control wizard |
    | `helpText` | Help text that can be added to an input form |
    | `numericInput` | A field to enter numbers |
    | `radioButtons` | A set of radio buttons |
    | `selectInput` | A box with choices to select from |
    | `sliderInput` | A slider bar |
    | `submitButton` | A submit button |
    | `textInput` | A field to enter text |
    ")
  ), 
  
  layout_columns(
    col_width = 3,
    
    # 按钮
    card(
      card_header("Buttons"),
      actionButton("action", "Action"),
      submitButton("Submit")
    ),
    
    # 勾选框
    card(
      card_header("Single checkbox"),
      checkboxInput("checkbox", "Choice A", value = TRUE)
    ),
    # 多选勾选框
    card(
      card_header("Checkbox group"),
      checkboxGroupInput(
        "checkGroup",
        "Select all that apply",
        choices = list("Choice 1" = 1, "Choice 2" = 2, "Choice 3" = 3),
        selected = 1
      )
    ),
    # 单选勾选框
    card(
      card_header("Radio buttons"),
      radioButtons(
        "radio",
        "Select option",
        choices = list("Choice 1" = 1, "Choice 2" = 2, "Choice 3" = 3),
        selected = 1
      )
    ),
    # 下拉单选框
    card(
      card_header("Select box"),
      selectInput(
        "select",
        "Select option",
        choices = list("Choice 1" = 1, "Choice 2" = 2, "Choice 3" = 3),
        selected = 1
      )
    ),
    
    # 日期选择器
    card(
      card_header("Date input"),
      dateInput("date", "Select date", value = "2014-01-01")
    ),
    # 日期选择器-from—to
    card(
      card_header("Date range input"),
      dateRangeInput("dates", "Select dates")
    ),
    
    # 文件上传
    card(
      card_header("File input"),
      fileInput("file", label = NULL)
    ),
    
    # 辅助性文本
    card(
      card_header("Help text"),
      helpText(
        "Note: help text isn't a true widget,",
        "but it provides an easy way to add text to",
        "accompany other widgets."
      )
    ),
    
    # 数字输入框
    card(
      card_header("Numeric input"),
      numericInput("num", "Input number", value = 1)
    ),
    # 文本输入框
    card(
      card_header("Text input"),
      textInput("text", label = NULL, value = "Enter text...")
    ),
    
    # 值滑块
    card(
      card_header("Sliders"),
      sliderInput(
        "slider1",
        "Set value",
        min = 0,
        max = 100,
        value = 50
      ),
      # 范围滑块
      sliderInput(
        "slider2",
        "Set value range",
        min = 0,
        max = 100,
        value = c(25, 75)
      )
    )

  )
)

server <- function(input, output, session) {
  
}

shinyApp(ui, server)

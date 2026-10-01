# if we want to use functions in forms as attributes (my_utils.str_util.str_reverse("abcd"))
# we need to let modules be exposed in the __init__.py in the package, like below"
from . import str_util
from . import file_util
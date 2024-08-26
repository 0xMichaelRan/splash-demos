# Ada Project Showcase

A Hugo theme for showcasing your project. Featuring the beautiful [Ada UI](https://gitlab.com/gabmus/ada-ui).

## Install

```bash
git submodule add https://gitlab.com/gabmus/hugo-ada-project-showcase.git themes/ada-project-showcase
git submodule update --init --recursive
```

## Configuration

**IMPORTANT**: this is not your standard theme! It requires additional configuration to work.

### Main configuration

`config.toml`

```toml
baseURL = "https://example.org"
theme = "ada-project-showcase"

# This will be the main site title, ad will appear in the Header
title = "My New Hugo Site"

# This is the copyright notice, it will appear in the footer, after "<current year> ©"
copyright = "Gabriele Musco"

# It is recommended to disable these built-in hugo types, as they don't do
# anything with this theme and don't have a use for the scope of this theme
disableKinds = ["RSS", "section", "categories", "tags"]

[params]
    # This will show up along in the title tag in head, after the title, and
    # in the splash if no subtitle is specified there
    subtitle = "Some subtitle"

    # These links will appear in the Header
    links = [
        ["Features", "/#features"],
        ["Download", "/#download"],
        ["More", "/#more"],
    ]

    # This logo will appear in the header, left of the title
    logo = "/logo-symbolic.svg"
    favicon = "/favicon.png"

    # if both license and licenseLink are populated, the content license will
    # be shown in the footer
    license = "CC-BY-SA-4.0"
    licenseLink = "https://creativecommons.org/licenses/by-sa/4.0/"

    # customize the color of the header. value can be one of: blue, red,
    # orange, yellow, green, purple (default is blue)
    headerColor = "purple"
    # make the header fixed. if splash is enabled and
    # fixedHeaderInitiallyTransparent is false or unset, activating this will
    # force the header to have a background color, despite headerColor being
    # unset. this is to avoid a weird appearance with a fixed transparent header
    fixedHeader = true
    # the header will be transparent when the view is at the beginning, meaning
    # when the vertical scroll position is 0
    fixedHeaderInitiallyTransparent = true

    # redirect to baseURL if current URL host doesn't match
    # useful if deploying in gitlab pages with custom domain and don't want
    # the username.gitlab.io/website url to persist
    forceRedirect = true
```

### Splash

The topmost component, just below the header, is called splash.

If enabled, splash will always be the first section.

It serves as a brief and visually appealing presentation of the project you're showcasing.

The Splash is controlled with this file: `data/splash.yml`. Following is an example configuration.

```yaml
enabled: true
# icon is a url for an optional icon that will be shown to the left of the title
icon: /my-fancy-logo.svg
title: My awesome project
subtitle: A demo project for Ada Project Showcase
# background is a url for an optional background image
# if left blank, a customizable gradient will be used instead
background:
# the gradient takes 3 parameters: an angle and two color stops
# these values will be injected in the style sheet and need to use valid
# css syntax
gradient:
  angle: -55deg
  stop1: "#3584e4"
  stop2: "#33d17a"
# picture is a url for an optional picture that will be shown to the right of
# the title. it is recommended to use a screenshot of your project here
# or alternatively a nice vector graphic
picture: https://picsum.photos/800/600
# these buttons represent links that will be shown under the title
# they represent quick actions you want your user to take, like Install or
# Discover features
#
# Each button has different properties:
# - title is a string, will be shown as the button text
# - link is the url to which the button should navigate the user to
# - color can be one of the following: blue, red, orange, yellow, green,
#   purple (default is blue)
# - outline activates an alternative style with which the button has a
#   transparent background and colored outline
# - squared activates an alternative style with which the button has no border
#   radius. this makes for a more serious and less playful appearance
# the only mandatory properties are title and link
buttons:
  - title: Install
    link: "#install"
    color: purple
  - title: Discover the features
    link: "#features"
    outline: true
  - title: More
    link: "#"
    squared: true
```

### Footer columns

You can add various columns of links in the footer using the `data/footer_columns.yml` file.

Following is an example configuration:

```yaml
- title: My other projects
  links:
    - title: HydraPaper
      link: https://hydrapaper.gabmus.org
    - title: Ada UI
      link: https://gitlab.com/gabmus/ada-ui
- title: About me
  links:
    - title: My personal website
      link: https://gabmus.org
    - title: My GitLab
      link: https://gitlab.com/gabmus
    - title: My GNOME GitLab
      link: https://gitlab.gnome.org/gabmus
```

### Sections

#### Organizing your sections

This theme supports different kind of sections, described in detail below.

Which sections you want in your website, and the order they appear in, is controlled by the file `data/sections.yml`.

Following is an example:

```yaml
- type: markdown
  data: description
- type: gallery
  data: gallery
- type: downloads
  data: downloads
- type: markdown
  data: more
```

The order you specify in the config is kept as is.

The type `markdown` expects `.md` files inside `/content`.

All other types expect `.yml` files inside `/data`.

#### Markdown section

This section serves as a descriptive part of your project showcase.

Its data is a plain markdown file (name without extension) that supports the usual Hugo special sauce. Nothing really particular about this section.

If the value `data` is `description` it expects to find the file in `/content/description.md`.

#### Downloads section

This section allows the user to download the project. 

Following is an example configuration:

```yaml
enabled: true
# this will show up on top of the section as a h1
title: Download now
downloads:
  - distro: Flathub
    logo:
    button_title: Download on Flathub
    button_link: "#"
    button_color: purple
    commands: |
      flatpak --user install org.gabmus.whatever
  - distro: Fedora
    logo:
    commands: |
      ls -l /
      echo "Foo"
  - distro: Debian (unstable)
    icon: debian
    commands: |
      ls -l /
      echo "Foo"
  - distro: foobar
    logo: /logo-boxed.svg
    button_title: Foo that bar
    button_link: "#"
    button_outline: true
    button_squared: true
```

Here's an explanation of the vairious options you can set in a single download card:

| Option | Description |
|---|---|
| `distro` | Distro is the kind of distribution for this item. it will be shown inside the download card. If this name matches a file in `/static/distro-icons` an icon will be provided automatically, if the `logo` parameter below isn't specified |
| `logo` | Specify a url for a logo representing your distro. Will be shown atop the distro name in the download card. Make sure this image works well in both light and dark mode |
| `icon` | Specify an icon name for a built in icon, instead of using `distro` |
| `button_title` | The text inside the optional button prompting the user to visit an external link. Using the built-in button is useful to point the user to something like an app store. To make the button appear you need to set both `button_title` and `button_link` |
| `button_link` | The url that the button will point to. To make the button appear you need to set both `button_title` and `button_link` |
| `button_color` | Optional parameter to specify the color of the button. Can be one of: blue, red, orange, yellow, green, purple (default is blue) |
| `button_outline` | The button will use the *outline* alternate style |
| `button_squared` | The button will use the *squared* alternate style |
| `commands` | This optional text represents commands the user can run in their terminal to install the project. This will syntax highlight for bash |

#### Gallery section

An interactive image gallery.

Following is an example configuration:

```yaml
enabled: true
title: Screenshots
pictures:
  - https://picsum.photos/seed/adaui0/800/600
  - https://picsum.photos/seed/adaui1/800/600
```

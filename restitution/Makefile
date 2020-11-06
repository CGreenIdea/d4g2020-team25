default: clean documents

# Get some nice Fonts for rendering
fonts:
	# Download the package (selected from https://fonts.google.com/featured/Superfamilies)
	wget -O src/resources/fonts/fonts.zip https://cdn.freefontsvault.com/wp-content/uploads/2020/06/15194108/calibri-font.zip
	# Unzip the package and overwrite existing fonts
	unzip -o src/resources/fonts/fonts.zip -d src/resources/fonts/
	rm src/resources/fonts/fonts.zip

# Remove previous builds
clean:
	rm -fv restitution-d4g-team25.pdf

# Compile each document file into its own PDF
documents:
	asciidoctor-pdf \
			-o restitution-d4g-team25.pdf \
			-a doctype=article \
			-a pdf-stylesdir=src/resources/themes \
			-a pdf-style=d4g-theme.yml \
			-a pdf-fontsdir=src/resources/fonts \
			-a imagesdir=images \
			src/asciidoctor/restitution-d4g-team25.adoc

Rails.application.configure do

  config.cache_classes = false


  config.eager_load = false

  config.consider_all_requests_local       = true

  config.action_controller.perform_caching = false

  config.action_mailer.raise_delivery_errors = false

  config.active_support.deprecation = :log

  config.active_record.migration_error = :page_load

  config.assets.debug = true

  config.assets.raise_runtime_errors = true

  #needed for devise authentication
  config.action_mailer.default_url_options = { host: 'localhost', port: 3000 }

  # needed for paperclip
  Paperclip.options[:command_path] = "C:/Program Files/ImageMagick-6.9.0-Q16"
  Paperclip.options[:command_path] = "C:/Program Files/ImageMagick-6.9.0-Q16/identify"
  Paperclip.options[:command_path] = 'C:\Program Files (x86)\GnuWin32\bin'

end
